package org.jboss.as.quickstarts.cdi.scopes.service;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;

import org.jboss.as.quickstarts.cdi.scopes.qualifier.Scope;
import org.jboss.as.quickstarts.cdi.scopes.qualifier.Scope.Type;

public class ParagraphProducer {

	@Produces @Scope(Type.REQUEST) @RequestScoped
	private Paragraph requestParagraph = new Paragraph();
	
	@Produces @Scope(Type.SESSION) @SessionScoped
	private Paragraph sessionParagraph = new Paragraph();
	
	@Produces @Scope(Type.APPLICATION) @ApplicationScoped
	private Paragraph applicationParagraph = new Paragraph();
	
	@Produces @Scope(Type.CONVERSATION) @ConversationScoped
	private Paragraph conversationParagraph = new Paragraph();
	
}
