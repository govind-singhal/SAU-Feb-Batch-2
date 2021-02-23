import java.io.Serializable;

@SuppressWarnings("serial")
public class students implements Serializable{
	private int roll;
	private int totalMarks;
	private int rank;

	public students() {
		this.totalMarks = 0;
		this.rank = -1;
	}

	void setroll(int roll) {
		this.roll = roll;
	}
	int getroll() {
		return roll;
	}
	void setTotalMarks(int marks) {
		this.totalMarks = this.totalMarks + marks;
	}
	int getTotalMarks() {
		return totalMarks;
	}
	void setRank(int rank) {
		this.rank = rank;
	}
	int getRank() {
		return rank;
	}
	public String toString() {
        return "students{" +
        		rank + '\'' +
                roll + '\'' +
                + totalMarks + '\'' +
                "}\n";
    }

}
