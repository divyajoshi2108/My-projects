package com.brainmentors.Questions;

public class Questions {
	private String Question;
	private String Answer[]=new String[4];
    private	String YAns;
	private String RAns;
	private int Score;
	private boolean Answered;
	
	
	public boolean isAnswered() {
		return Answered;
	}
	public void setAnswered(boolean answered) {
		Answered = answered;
	}
	public Questions(int choice){
		/*this .Question= Question;
		this.Answer= Answer;
		this.YAns=YAns;
		this.RAns=RAns;
		this.Score=Score;*/
		ChooseQuestions(choice);
		
	}
	public void ChooseQuestions(int choice){
		switch (choice){
		case 0:
		{
		setQuestion(":Which is the largest country in the world?");
		String a[]={"America","India","Japan","Russia"};
		setAnswer(a);
		setRAns("D");
			break;
		}
		case 1:
		{
			setQuestion(":what is the national flower of india?");
			String a[]={"lily","rose","lotus","marigold"};
			setAnswer(a);
			setRAns("C");
				break;
		}
		case 2:
		{	
			setQuestion(":Which is the largest river in the world?");
			String a[]={"ganga","nile","jamuna","Ravi"};
			setAnswer(a);
		setRAns("B");
			break;
			
		}
	
			
		}
	}

	@Override
	public String toString() {
		return "Questions [Question=" + Question + "]";
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
		return YAns;
	}

	public void setYAns(String yAns) {
		YAns = yAns;
	}

	public String getRAns() {
		return RAns;
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
