package de.vollweiter.alexa;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.LaunchRequest;
import com.amazon.ask.model.Response;
import com.amazon.ask.request.Predicates;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

public class LaunchRequestHandler implements RequestHandler
{
    public boolean canHandle( HandlerInput handlerInput )
    {
        // Returns true if launch request
        return handlerInput.matches( Predicates.requestType( LaunchRequest.class));
    }

    public Optional<Response> handle( HandlerInput handlerInput )
    {
        String speechText = getRandomResponse();

        return handlerInput.getResponseBuilder()
        .withSpeech(speechText)
        .withSimpleCard("Dominic", speechText)
        .withReprompt(speechText)
        .build();
    }

    private String getRandomResponse() {
        List<String> possibleAnswers = new ArrayList<>(  );
        possibleAnswers.add( "<speak>Ich bin auf der Suche nach <prosody rate=\"slow\">wahrer</prosody> Liebe!</speak>" );
        possibleAnswers.add( "<speak>Das ist nicht schwarz, das ist <lang xml:lang=\"fr-FR\">Gelin</lang> farben!</speak>" );
        possibleAnswers.add( "Expertengruppen sind eh fuer den Arsch!" );
        possibleAnswers.add( "<speak>Meiner ist <lang xml:lang=\"de-DE\">laenger</lang> als deiner!</speak>" );
        possibleAnswers.add( "Ich bin schon ganz feucht..." );
        possibleAnswers.add( "<speak>Ich bin schon ganz <prosody rate=\"x-fast\">wuschig</prosody>!</speak>" );
        possibleAnswers.add( "Du bist halt kein Gewinnertyp - So wie ich!" );
        possibleAnswers.add( "Mit dir verlieren wir wenigstens niemand wertvolles!" );
        possibleAnswers.add( "Was interessiert mich dem sein gelaber" );
        possibleAnswers.add( "Das ist unschaetzbar - aber nicht wertvoll gemeint!" );
        int randomNum = ThreadLocalRandom.current().nextInt( 0, possibleAnswers.size());
        return possibleAnswers.get( randomNum );
    }
}
