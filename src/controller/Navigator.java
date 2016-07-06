package controller;

import java.sql.Timestamp;

import model.Price;
import model.Shop;
import model.Tube;
import ui.AddRecordFrame;
import ui.EditPrice;
import ui.ManagementFrame;
import ui.SearchTubeFrame;
import ui.SizeFilteredFrame;
import ui.SizesFrame;

public class Navigator {

	private static Navigator instance = new Navigator();

	private AddRecordFrame addRecordFrame;
	private Page page = Page.MANAGEMENT;
	private ManagementFrame managementFrame = new ManagementFrame();
	private SizesFrame sizesFrame = null;
	private SizeFilteredFrame sizeFilteredFrame;
	private State state = null;
	private SearchTubeFrame searchTubeFrame;
	private EditPrice editPrice = null;

	private Shop savedShop;

	public static Navigator getInstance() {
		
		
		
		
		
		return Navigator.instance;
	}

	public enum Page {
		SIZES, MANAGEMENT, FILTERED_BY_SIZE, ADD_RECORD, SEARCH_TUBE, EDIT_PRICE
	}

	public enum State {
		ADD_TUBE_PRICE, SEARCH_TUBE_SIZE

	}

	

	public void action(String string) {
		if(string.equals("exit")){
			System.exit(0);
			return;
		}
		
		if (page == Page.MANAGEMENT) {
			if (string.equals("1")) {
				this.page = Page.SIZES;
				this.state = State.ADD_TUBE_PRICE;
				this.managementFrame.setVisible(false);
				this.getSizesFrame().setVisible(true);
			} else if (string.equals("2")) {
				this.page = Page.SIZES;
				this.state = State.SEARCH_TUBE_SIZE;
				this.managementFrame.setVisible(false);
				this.getSizesFrame().setVisible(true);
			}
		} else if (this.page == Page.SIZES) {
			if (this.state == State.ADD_TUBE_PRICE) {
				if (string.equals("return")) {
					this.getSizesFrame().setVisible(false);
					this.page = Page.MANAGEMENT;
					this.managementFrame.setVisible(true);
				}
			} else if (this.state == State.SEARCH_TUBE_SIZE) {
				if (string.equals("return")) {
					this.getSizesFrame().setVisible(false);
					this.page = Page.MANAGEMENT;
					this.managementFrame.setVisible(true);
				}
			}
		} else if (this.page == Page.ADD_RECORD
				&& this.state == State.ADD_TUBE_PRICE) {

			if (string.equals("cancel")) {
				this.addRecordFrame.setVisible(false);
				// this.savedShop = (Shop) object;
				this.page = Page.SIZES;
				this.getSizesFrame().setVisible(true);

			}
		} else if (this.page == Page.SEARCH_TUBE
				&& this.state == State.SEARCH_TUBE_SIZE) {
			if (string.equals("return")) {
				this.page = Page.SIZES;
				this.searchTubeFrame.setVisible(false);
				this.getSizesFrame().setVisible(true);
			}
		} else if (this.page == Page.EDIT_PRICE) {
			if (this.state == State.ADD_TUBE_PRICE) {
				if (string.equals("done")) {
					this.editPrice.setVisible(false);
					try {
						this.addRecordFrame.getCrudPnl().refreshData();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					this.addRecordFrame.setEnabled(true);
					this.addRecordFrame.setVisible(true);
					this.page = Page.ADD_RECORD;

				}
			}
		}
	}

	public void action(String str, Object object) {
		if (this.page == Page.FILTERED_BY_SIZE
				&& this.state == State.ADD_TUBE_PRICE) {
			this.sizeFilteredFrame.setVisible(false);
			this.sizeFilteredFrame.dispose();
			this.addRecordFrame = new AddRecordFrame((Tube) object);
			this.page = Page.ADD_RECORD;
			if (this.savedShop != null) {
				this.addRecordFrame.setShop(this.savedShop);
			}
			this.addRecordFrame.setVisible(true);

		} else if (this.page == Page.SIZES) {
			if (this.state == State.ADD_TUBE_PRICE) {
				if (object.equals("select")) {
					this.page = Page.FILTERED_BY_SIZE;
					this.getSizesFrame().setVisible(false);
					this.sizeFilteredFrame = new SizeFilteredFrame(str);
					this.sizeFilteredFrame.setVisible(true);
				}
			} else if (this.state == State.SEARCH_TUBE_SIZE) {
				if (object.equals("select")) {
					this.page = Page.SEARCH_TUBE;
					this.getSizesFrame().setVisible(false);
					/**
					 * sdlkdmnasjibdubasu
					 */
					// this.searchTubeFrame = new SearchTubeFrame(str);
					this.searchTubeFrame = new SearchTubeFrame(str);
					this.searchTubeFrame.setVisible(true);
				}
			}
		} else if (this.page == Page.ADD_RECORD) {
			if (this.state == State.ADD_TUBE_PRICE) {
				if (str.equals("select-size")) {
					this.addRecordFrame.setVisible(false);
					this.savedShop = (Shop) object;
					this.page = Page.SIZES;
					this.getSizesFrame().setVisible(true);

				}else if (str.equals("edit")) {
					this.addRecordFrame.setEnabled(false);
					this.editPrice = new EditPrice((Price)object);
					this.editPrice.setVisible(true);
					this.page = Page.EDIT_PRICE;
					
				}
			}

		}
	}

	public SearchTubeFrame getSearchTubeFrame() {
		return searchTubeFrame;
	}

	public void setSearchTubeFrame(SearchTubeFrame searchTubeFrame) {
		this.searchTubeFrame = searchTubeFrame;
	}

	public SizesFrame getSizesFrame() {
		if (this.sizesFrame == null) {
			this.setSizesFrame(new SizesFrame());
		}
		return sizesFrame;
	}

	public void setSizesFrame(SizesFrame sizesFrame) {
		this.sizesFrame = sizesFrame;
	}
}
