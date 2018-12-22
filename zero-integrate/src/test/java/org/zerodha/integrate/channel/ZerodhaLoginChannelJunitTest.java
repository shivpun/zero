package org.zerodha.integrate.channel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.PollableChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerodha.domain.ZerodhaCredential;
import org.zerodha.domain.ZerodhaCredentialResponse;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:/zerodha-integrate.xml"})
public class ZerodhaLoginChannelJunitTest {
	
	@Value(value = "${zerodha.userId}")
	private String userId;
	
	@Value(value = "${zerodha.password}")
	private String password;

	@Autowired
	@Qualifier(value = "zerodha-credential")
	private MessageChannel messageChannel;
	
	@Autowired
	@Qualifier(value = "zerodha-twofa")
	private PollableChannel pollableChannel;
	
	@Test
	public void testZerodhaLogin() {
		ZerodhaCredential zerodhaCredential = new ZerodhaCredential();
		zerodhaCredential.setUserId(userId);
		zerodhaCredential.setPassword(password);
		Message<?> message = MessageBuilder.withPayload(zerodhaCredential).build();
		messageChannel.send(message);
		Message<ZerodhaCredentialResponse> pollMsg = (Message<ZerodhaCredentialResponse>) pollableChannel.receive();
		assertNotNull(pollMsg);
		ZerodhaCredentialResponse credentialResponse = pollMsg.getPayload();
		assertEquals("success", credentialResponse.getStatus());
	}
}
