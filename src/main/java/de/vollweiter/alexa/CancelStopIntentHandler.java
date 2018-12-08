package de.vollweiter.alexa;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

import static com.amazon.ask.request.Predicates.intentName;

public class CancelStopIntentHandler implements RequestHandler {
    @Override
    public boolean canHandle(HandlerInput handlerInput) {
        return handlerInput.matches(intentName("AMAZON.StopIntent").or(intentName("AMAZON.CancelIntent")));
    }

    @Override
    public Optional<Response> handle(HandlerInput handlerInput) {
        String speechText = getRandomResponse();

        return handlerInput.getResponseBuilder()
                .withSpeech(speechText)
                .withSimpleCard("Dominic", speechText)
                .build();
    }

    private String getRandomResponse() {
        List<String> possibleAnswers = new ArrayList<>();
        possibleAnswers.add("Jetzt verzieh dich");
        possibleAnswers.add("Ist auch besser so");
        int randomNum = ThreadLocalRandom.current().nextInt(0, possibleAnswers.size() + 1);
        return possibleAnswers.get(randomNum);
    }
}
