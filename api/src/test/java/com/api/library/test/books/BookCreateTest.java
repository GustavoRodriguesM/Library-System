package com.api.library.test.books;

import static org.junit.Assert.assertThat;

import java.io.IOException;

import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.api.library.test.configurations.AbstractTest;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookCreateTest extends AbstractTest {

	@Test
	public void test() throws ClientProtocolException, IOException {
		CloseableHttpClient client = HttpClients.createDefault();

		HttpPost httpPost = new HttpPost("http://localhost:9000/books");
		httpPost.setEntity(new StringEntity(this.jsonResource(), "UTF-8"));
		httpPost.setHeader("Accept", "application/json");
		httpPost.setHeader("Content-Type", "application/json;charset=UTF-8");
		this.getAuthenticationHeader(httpPost);

		CloseableHttpResponse response = client.execute(httpPost);

		assertThat(response.getStatusLine().getStatusCode(), Matchers.is(HttpStatus.SC_CREATED));
	}

	private String jsonResource() {
		return "{" + "	\"title\": \"Harry Potter E A Pedra Filosofal\","
				+ "	\"description\": \"Harry Potter é um garoto cujos pais, feiticeiros, foram assassinados por um poderosíssimo bruxo quando ele ainda era um bebê. Ele foi levado, então, para a casa dos tios que nada tinham a ver com o sobrenatural. Pelo contrário. Até os 10 anos, Harry foi uma espécie de gata borralheira: maltratado pelos tios, herdava roupas velhas do primo gorducho, tinha óculos remendados e era tratado como um estorvo. No dia de seu aniversário de 11 anos, entretanto, ele parece deslizar por um buraco sem fundo, como o de Alice no país das maravilhas, que o conduz a um mundo mágico. Descobre sua verdadeira história e seu destino: ser um aprendiz de feiticeiro até o dia em que terá que enfrentar a pior força do mal, o homem que assassinou seus pais. O menino de olhos verde, magricela e desengonçado, tão habituado à rejeição, descobre, também, que é um herói no universo dos magos. Potter fica sabendo que é a única pessoa a ter sobrevivido a um ataque do tal bruxo do mal e essa é a causa da marca em forma de raio que ele carrega na testa. Ele não é um garoto qualquer, ele sequer é um feiticeiro qualquer; ele é Harry Potter, símbolo de poder, resistência e um líder natural entre os sobrenaturais. A fábula, recheada de fantasmas, paredes que falam, caldeirões, sapos, unicórnios, dragões e gigantes, não é, entretanto, apenas um passatempo.\","
				+ "	\"units\": 5," + "	\"isbn\": \"978-8532511010\","
				+ "	\"cover\": \"http://localhost:9000/public/51dVJQpySjL._SX331_BO1,204,203,200_.jpg\","
				+ "	\"categories\": [\"http://localhost:9000/categories/1\"],"
				+ "	\"authors\": [\"http://localhost:9000/authors/3\"]" + "}";
	}

}
