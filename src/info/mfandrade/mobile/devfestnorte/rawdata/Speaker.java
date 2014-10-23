package info.mfandrade.mobile.devfestnorte.rawdata;

public class Speaker {

	private String _name;
	private String _company;
	private String _minibio;
	private byte[] _photo;

	public Speaker(String name, String company) {
		setName(name);
		setCompany(company);
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getCompany() {
		return _company;
	}

	public void setCompany(String company) {
		_company = company;
	}

	public String getMinibio() {
		return _minibio;
	}

	public void setMinibio(String minibio) {
		_minibio = minibio;
	}

	public byte[] getPhoto() {
		return _photo;
	}

	public void setPhoto(byte[] photo) {
		_photo = photo;
	}

	@Override
	public String toString() {
		return _name + " (" + _company + ")";
	}
}
