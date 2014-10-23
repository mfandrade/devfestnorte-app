package info.mfandrade.mobile.devfestnorte.rawdata;

public final class Event {

	private static Event theEvent;

	private Event() {
	}

	public static Event getInstance() {
		if (theEvent == null) {
			theEvent = new Event();
		}
		return theEvent;
	}

	public Talk[] getTalks(int section) {
		Talk[] ret = null;
		if (section == 0) {
			ret = new Talk[11];
			ret[0] = new Talk("(KEYNOTE) Os desafios do desenvolvimento do EasyTaxi nos 33 países", "9:00");
			ret[1] = new Talk("Coffee-break", "10:00");
			ret[2] = new Talk("AngularJS: aspectos práticos visando a rapidez", "10:30");
			ret[3] = new Talk("Conhecendo Go", "11:30");
			ret[4] = new Talk("Intervalo para almoço", "12:30");
			ret[5] = new Talk("Desenvolvimento orientado a testes com AngularJS", "13:30");
			ret[6] = new Talk("Go para microsserviços", "14:30");
			ret[7] = new Talk("Coffee-break", "15:30");
			ret[8] = new Talk("WebRTC: transmissão de áudio e vídeo em tempo real com HTML5", "16:00");
			ret[9] = new Talk(
					"(KEYNOTE) Um overview sobre as novidades e tudo o que o Google tem para desenvolvedores", "17:00");
		} else if (section == 1) {
			ret = new Talk[11];
			ret[0] = new Talk("(KEYNOTE) Os desafios do desenvolvimento do EasyTaxi nos 33 países", "9:00");
			ret[1] = new Talk("Coffee-break", "10:00");
			ret[2] = new Talk("O caminho de um desenvolvedor Android", "10:30");
			ret[3] = new Talk("Desenvolvimento de jogos para Android", "11:30");
			ret[4] = new Talk("Intervalo para almoço", "12:30");
			ret[5] = new Talk("Animando a UI: entregue uma experiência, não apenas um aplicativo", "13:30");
			ret[6] = new Talk("Ionic Framework: aplicações móveis híbridas com HTML5 e AngularJS", "14:30");
			ret[7] = new Talk("Coffee-break", "15:30");
			ret[8] = new Talk("Android L: conheça as novidades e tendências", "16:00");
			ret[9] = new Talk(
					"(KEYNOTE) Um overview sobre as novidades e tudo o que o Google tem para desenvolvedores", "17:00");
		}
		return ret;
	}

}
