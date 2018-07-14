package com.divya.actions.question;


public class Questions {
	private int Qid;
	private String Question;
	private String Answer[]=new String[4];
    private	String YAns="NIL";
	private String RAns;
	private int Score;
	private boolean Answered;
	
	
	public boolean isAnswered() {
		return Answered;
	}
	public void setAnswered(boolean answered) {
		Answered = answered;
	}
	
	@Override
	public String toString() {
		return "Questions [Question=" + Question + "]";
	}
	public Questions(int Qid ,String question, String[] answer, String yAns, String rAns) {
		super();
		this.Qid=Qid;
		Question = question;
		Answer = answer;
		YAns = yAns;
		RAns = rAns;
	}
	public String getQuestion() {
		return Question;
	}

	public void setQuestion(String question) {
		Question = question;
	}

	public String[] getAnswer() {
		return Answer;
	}

	public void setAnswer(String[] answer) {
		Answer = answer;
	}

	public String getYAns() {
		//YAns="lotus";
		//System.out.println("Getter Call "+YAns);
		return YAns;
	}

	public void setYAns(String yAns) {
		//YAns="lotus";
		//System.out.println("Set YANS "+YAns);
		YAns = yAns;
	}

	public String getRAns() {
		return RAns;
	}

	public int getQid() {
		return Qid;
	}
	public void setQid(int qid) {
		Qid = qid;
	}
	public void setRAns(String rAns) {
		RAns = rAns;
	}

	public int getScore() {
		return Score;
	}

	public void setScore(int score) {
		Score = score;
	}
	

}
