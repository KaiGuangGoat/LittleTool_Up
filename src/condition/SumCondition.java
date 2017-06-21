package condition;

public class SumCondition extends BaseCondition{
	private static final int MAX_COUNT = 100;
	private String condition = CONDITION_2_DOT_1;//设置的条件
	private int sumGoal = 5;//设置的求和数
	
	
	
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public void setSumGoal(int sumGoal) {
		this.sumGoal = sumGoal;
	}
}
