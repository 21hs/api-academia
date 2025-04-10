package classes;

public class Feedback {
    private int id;
    private String memberName;     // Nome do aluno que fez o feedback
    private String comment;        // Comentário sobre a aula
    private int rating;            // Classificação da aula (ex: de 1 a 5)

    public Feedback() {}

    public Feedback(String memberName, String comment, int rating) {
        this.memberName = memberName;
        this.comment = comment;
        this.rating = rating;
    }

    public Feedback(int id, String memberName, String comment, int rating) {
        this.id = id;
        this.memberName = memberName;
        this.comment = comment;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public String getMemberName() {
        return memberName;
    }

    public String getComment() {
        return comment;
    }

    public int getRating() {
        return rating;
    }
}
