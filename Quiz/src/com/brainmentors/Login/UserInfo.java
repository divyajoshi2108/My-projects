package com.brainmentors.Login;

public class UserInfo {
	private int UserId;
	private String UserPwd;
	  private boolean Regflag;
	  public UserInfo(int UserId,String UserPwd){
		  this.UserId= UserId;
		  this.UserPwd=UserPwd;
	  }
	  

		@Override
		public boolean equals(Object object){
			if(object instanceof UserInfo){
				
				UserInfo item = (UserInfo) object; // Downcasting
				if(this.UserId>0 && this.UserPwd!=null && this.UserPwd.trim().length()>0){
					if(this.UserId == item.UserId && this.UserPwd.equals(item.UserPwd)){
						return true;
					}
				}
				else
				if(item.UserPwd!=null && item.UserPwd.trim().length()>0){
					if(this.UserPwd.equals(item.UserPwd)){
						return true;
					}
				}
				else
				if(item.UserId>0){
				if(this.UserId == item.UserId){
					return true;
				}
				}
			}
			return false;
		}
		
	  
	  
	  
	  
	public int getUserId() {
		return UserId;
	}
	public void setUserId(int userId) {
		UserId = userId;
	}
	public String getUsePwd() {
		return UserPwd;
	}
	public void setUsePwd(String usePwd) {
		UserPwd = usePwd;
	}
	public boolean isRegflag() {
		return Regflag;
	}
	public void setRegflag(boolean regflag) {
		Regflag = regflag;
	}

}
