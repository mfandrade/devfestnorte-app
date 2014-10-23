package info.mfandrade.mobile.devfestnorte.rawdata;

public class Talk {

	private String _title;
	private String _start;
	private String _description;
	private Speaker _speaker;

	public Talk(String title, String start) {
		setTitle(title);
		setStart(start);
	}

	public Talk(String title, String start, String description) {
		this(title, start);
		setDescription(description);
	}

	public Talk(String title, String start, String description, Speaker speaker) {
		this(title, start, description);
		setSpeaker(speaker);
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public String getStart() {
		return _start;
	}

	public void setStart(String start) {
		_start = start;
	}

	public Speaker getSpeaker() {
		return _speaker;
	}

	public void setSpeaker(Speaker speaker) {
		_speaker = speaker;
	}

	@Override
	public String toString() {
		return _start + " " + _title;
	}

}
