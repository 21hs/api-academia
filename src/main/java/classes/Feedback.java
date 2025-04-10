package classes;

public class Feedback {
    private int id;
    private String studentName;    // Nome do aluno que recebeu a avaliação
    private String comment;        // Comentário sobre o aluno
    private int rating;            // Classificação (nota de 1 a 5)

    public Feedback() {}

    public Feedback(String studentName, String comment, int rating) {
        this.studentName = studentName;
        this.comment = comment;
        this.rating = rating;
    }

    public Feedback(int id, String studentName, String comment, int rating) {
        this.id = id;
        this.studentName = studentName;
        this.comment = comment;
        this.rating = rating;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public String getMemberName() {
        return studentName;
    }

    public String getComment() {
        return comment;
    }

    public int getRating() {
        return rating;
    }
}
