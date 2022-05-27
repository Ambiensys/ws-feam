package ws.service.feam.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import ws.service.feam.exception.FeamException;
import ws.service.feam.modelo.unidade.FeamUsuarioUnidade;

@ApplicationScoped
public class FeamControlePesquisaUsuarioUnidades {
	
        @Inject
        @RestClient
        FeamRestClientService service;

	String auxCodigo = "";
	String auxNome = "";
	String auxEndereco ="";

	public List<FeamUsuarioUnidade> pesquisaUsuarioUnidades(String cnpj) throws IOException, FeamException {

            Response response = service.pesquisaUsuarioUnidades(cnpj, "pesquisaUsuarioUnidades");

            String msgResponse = response.readEntity(String.class);

            Document document = Jsoup.parse(msgResponse);
            Element table = document.select("table").first();
            String arrayName = table.select("th").first().text();
            JSONObject jsonObj = new JSONObject();
            JSONArray jsonArr = new JSONArray();
            Elements ttls = table.getElementsByTag("th");
            Elements nfos = table.getElementsByClass("center");

            List<FeamUsuarioUnidade> retorno = new ArrayList<FeamUsuarioUnidade>();
            int j = 0;

            for (int i = 0, l = nfos.size(); i < l; i++) {
                     JSONObject jo = new JSONObject();
                    if(i % 3 == 0) {
                            j = 0;
                            this.auxCodigo =  "";
                            this.auxNome = "";
                            this.auxEndereco = "";

                    }

                             String key = ttls.get(j).text();
                     String value = nfos.get(i).text();

                     if(key.equals("Codigo")) {
                             auxCodigo = value;
                     }else if(key.equals("Nome")) {
                             auxNome = value;
                     }else if(key.equals("Endereço")) {
                             auxEndereco =value;
                     }

                     jo.put(key, value);
                     jsonArr.put(jo);

                     if(!auxCodigo.equals("") && !auxNome.equals("") && !auxEndereco.equals("")) {
                             FeamUsuarioUnidade feamUsuarioUnidade = new FeamUsuarioUnidade();

                             feamUsuarioUnidade.setCodigo(auxCodigo);
                             feamUsuarioUnidade.setNome(auxNome);
                             feamUsuarioUnidade.setEndereco(auxEndereco);
                             retorno.add(feamUsuarioUnidade);
                     }

             j++;
        	
        }

       
        return retorno;
    }
}
