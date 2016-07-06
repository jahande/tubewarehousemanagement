package ui.model;

import javax.swing.JLabel;

public class ParameterLabel<E> extends JLabel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6052876487028949161L;
	private E parameter = null;
	public E getParameter() {
		return this.parameter;
	}
	public void setParameter(E parameter) {
		this.parameter= parameter;
	}
	

}
