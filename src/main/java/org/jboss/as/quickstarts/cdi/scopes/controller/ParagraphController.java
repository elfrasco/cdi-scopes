/*
 * JBoss, Home of Professional Open Source
 * Copyright 2013, Red Hat, Inc. and/or its affiliates, and individual
 * contributors by the @authors tag. See the copyright.txt in the
 * distribution for a full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jboss.as.quickstarts.cdi.scopes.controller;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Conversation;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.jboss.as.quickstarts.cdi.scopes.qualifier.Scope;
import org.jboss.as.quickstarts.cdi.scopes.qualifier.Scope.Type;
import org.jboss.as.quickstarts.cdi.scopes.service.Paragraph;

@Named("paragraphCtrl")
@ApplicationScoped
public class ParagraphController {
	
	@Inject @Scope(Type.REQUEST)
	private Paragraph request;
	
	@Inject @Scope(Type.SESSION)
	private Paragraph session;
	
	@Inject @Scope(Type.APPLICATION)
	private Paragraph application;
	
	@Inject @Scope(Type.CONVERSATION)
	private Paragraph conversation;
	
	@Inject
	private Conversation conv;
	
	// texts to add
	private String requestText = "";
	private String sessionText = "";
	private String applicationText = "";
	private String conversationText = "";
	
	// Button methods
	public void addRequestText() {
		request.add(requestText);
		requestText = "";
	}

	public void addSessionText() {
		session.add(sessionText);
		sessionText = "";
	}

	public void addApplicationText() {
		application.add(applicationText);
		applicationText = "";
	}

	public void addConversationText() {
		conversation.add(conversationText);
		conversationText = "";
	}
	
	public void addAllTexts() {
		addRequestText();
		addSessionText();
		addApplicationText();
		addConversationText();
	}
	
	public void beginConversation() {
		conv.begin();
	}

	public void endConversation() {
		conv.end();
	}
	
	public String getConversationId() {
		return conv.getId();
	}
	
	public void invalidateSession() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
	}
	
	// Setters and Getters
	public String getRequestText() {
		return requestText;
	}

	public void setRequestText(String requestText) {
		this.requestText = requestText;
	}

	public String getSessionText() {
		return sessionText;
	}

	public void setSessionText(String sessionText) {
		this.sessionText = sessionText;
	}

	public String getApplicationText() {
		return applicationText;
	}

	public void setApplicationText(String applicationText) {
		this.applicationText = applicationText;
	}

	public String getConversationText() {
		return conversationText;
	}

	public void setConversationText(String conversationText) {
		this.conversationText = conversationText;
	}

	public Paragraph getRequest() {
		return request;
	}

	public void setRequest(Paragraph request) {
		this.request = request;
	}

	public Paragraph getSession() {
		return session;
	}

	public void setSession(Paragraph session) {
		this.session = session;
	}

	public Paragraph getApplication() {
		return application;
	}

	public void setApplication(Paragraph application) {
		this.application = application;
	}

	public Paragraph getConversation() {
		return conversation;
	}

	public void setConversation(Paragraph conversation) {
		this.conversation = conversation;
	}
	
}
