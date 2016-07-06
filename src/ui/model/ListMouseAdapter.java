package ui.model;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ListMouseAdapter<E> extends MouseAdapter {
	private final ListMouseListenner listenner;
	private final E listElement;
	private final String type;

	private ListMouseAdapter() {
		this(null,null);
	}

	public ListMouseAdapter(E inf,ListMouseListenner listenner) {
		this(inf,listenner,"");
	}
	public ListMouseAdapter(E inf,ListMouseListenner listenner,String type) {
		this.listElement = inf;
		this.listenner = listenner;
		this.type = type;
	}

	public void mouseClicked(MouseEvent e) {
		this.listenner.listMouseListennerActionPerform(e, this.listElement,this.type);
	}

	
}