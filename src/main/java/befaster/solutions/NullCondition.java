package befaster.solutions;

class NullCondition implements ICondition {
	
	@Override
	public int getNumberOfApplications(Bill bill) {
		return Integer.MAX_VALUE;
	}

}
