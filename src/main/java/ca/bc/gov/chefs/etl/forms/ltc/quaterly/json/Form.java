package ca.bc.gov.chefs.etl.forms.ltc.quaterly.json;

public class Form{
    public String assignee;
    public String assigneeEmail;
    public String confirmationId;
    public String createdAt;
    public String email;
    public String formName;
    public String fullName;
    public String status;
    public String username;
    public String version;
    
	public String getAssignee() {
		return assignee;
	}
	public void setAssignee(String assignee) {
		this.assignee = assignee;
	}
	public String getAssigneeEmail() {
		return assigneeEmail;
	}
	public void setAssigneeEmail(String assigneeEmail) {
		this.assigneeEmail = assigneeEmail;
	}
	public String getConfirmationId() {
		return confirmationId;
	}
	public void setConfirmationId(String confirmationId) {
		this.confirmationId = confirmationId;
	}
	public String getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFormName() {
		return formName;
	}
	public void setFormName(String formName) {
		this.formName = formName;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	
	@Override
	public String toString() {
		return "Form [assignee=" + assignee + ", assigneeEmail=" + assigneeEmail + ", confirmationId=" + confirmationId
				+ ", createdAt=" + createdAt + ", email=" + email + ", formName=" + formName + ", fullName=" + fullName
				+ ", status=" + status + ", username=" + username + ", version=" + version + "]";
	}
    
    
    
}
