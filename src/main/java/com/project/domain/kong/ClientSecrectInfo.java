package com.project.domain.kong;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class ClientSecrectInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2630224158747182665L;
	
	@JsonProperty("created_at")
	private Date createdAt;
	
	private ConsumerInfo consumer;
	
	private String id;
	
	@JsonProperty("client_id")
	private String clientId;
	
	private String name;
	
	@JsonProperty("client_secrect")
	private String clientSecrect;
	
	@JsonProperty("redirect_uris")
	private List<String> redirectUris;

}
