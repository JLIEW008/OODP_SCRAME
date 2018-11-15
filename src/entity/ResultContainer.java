package entity;

import java.util.List;

import java.util.ArrayList;

public class ResultContainer extends TypeFindableContainer{
	private List<Result> results = new ArrayList<Result>();

	@Override
	public ArrayList<Result> findByType(String id, int type) {//1,2,3
		ArrayList<Result> resultArray = new ArrayList<Result>();
		ArrayList<Integer> splits = findDash(id);
		if(splits.size() + 1 < type) {
			throw new IllegalArgumentException("The number of types is less than the integer param.");
		}
		int startingIndex = type == 1 ? 0 : splits.get(type-1);
		int endingIndex = splits.get(type) != -1 ? splits.get(type) : id.length();
		for(Result result : this.results) {
			if(result.getID().substring(startingIndex, endingIndex).equals(id)) {
				resultArray.add(result);
			}
		}
		return resultArray.size() == 0 ? null : resultArray;
	}

	@Override
	public Result findByID(String id) {
		for(Result result : this.results) {
			if(result.getID().equals(id)) {
				return result;
			}
		}
		return null;
	}
	
	private ArrayList<Integer> findDash(String id) {
		int index = 0;
		char dash = '-';
		ArrayList<Integer> indices = new ArrayList<Integer>();
		do {
			if((index = id.indexOf(dash, index + 1)) != -1) {
				indices.add(index);
			}
		}while(index != -1);
		return indices;
	}

	@Override
	public void add(Object o) {
		Result result = (Result)o;
		if(findByID(result.getID()) == null) {
			this.results.add(result);
		}
		throw new Exception("Student already exists");
	}

	@Override
	public void removeByID(String id) {
		Result result = findByID(id);
		if(result != null) {
			this.results.remove(result);
		}
		throw new Exception("Course not found");
	}
	
	private String concatenateID(ArrayList<String> ids) {
		String temp = "";
		String string;
		for(int index = 0; index < ids.size(); index++) {
			temp += (index < ids.size()) ? ids.get(index) + "-" : ids.get(index); 
		}
	}
}
