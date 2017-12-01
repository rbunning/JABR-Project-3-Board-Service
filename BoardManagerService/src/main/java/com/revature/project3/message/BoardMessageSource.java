package com.revature.project3.message;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface BoardMessageSource {

	@Output("boardmessage")
	MessageChannel boardMessage();

}
