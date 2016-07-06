package ui.model;

import java.util.ArrayList;

import javax.swing.ListModel;
import javax.swing.event.ListDataListener;

public class SimpleListModel implements ListModel{
	
	private ArrayList<String> elements ;//= new ArrayList<String>();
	
	public SimpleListModel() {
		this(new ArrayList<String>() );
	}
	public SimpleListModel(ArrayList<String> e){
		setElements(e);
	}
	
	public ArrayList<String> getElements(){
		return elements;
	}
	
	public void setElements(ArrayList<String> e){
		 elements=e;;
	}

	public void addListDataListener(ListDataListener l) {
		// TODO Auto-generated method stub
		
	}

	public Object getElementAt(int index) {
		return elements.get(index);
	}

	public int getSize() {
		return elements.size();
	}

	public void removeListDataListener(ListDataListener l) {
		// TODO Auto-generated method stub
		
	}

}
