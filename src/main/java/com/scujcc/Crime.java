package com.scujcc;

public class Crime {
	  private String id;
	  private String title;
	  private String date;
	  private String description;
	  private Boolean solved;
	  
	  public Crime() {}
public Crime(String id,String title,String createDate,
			String description,Boolean solved){
	this.id = id;
	this.title = title;
	this.date = createDate;
	this.description = description;
	this.solved = solved;

}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCreateDate() {
		return date;
	}
	public void setCreateDate(String createDate) {
		this.date = createDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Boolean getSolved() {
		return solved;
	}
	public void setSolved(Boolean solved) {
		this.solved = solved;
	}


@Override
public String toString(){
    return String.format("id=%s, title=%s,description=%s,solved=%b,createdate=%s",id,title,description,solved,date);
//	StringBuilder builder = new StringBuilder();
//	builder.append("Crime [id");
//	builder.append(id);
//	return builder.toString();
	}
	  
}
