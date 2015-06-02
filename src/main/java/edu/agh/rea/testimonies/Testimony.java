package edu.agh.rea.testimonies;

public class Testimony {

	private static int nextCaseId = 1;
	private int testimonyId = Testimony.nextCaseId();
	private String witness;
	private String content;

	public Testimony(String witness, String content) {
		this.witness = witness;
		this.content = content;
	}
	
	private static int nextCaseId() {
		return nextCaseId++;
	}

	public String getContent() {
		return content;
	}

    public String getAuthor() {
        return witness;
    }
	
}
