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

public class LaunchRequestHandler implements RequestHandler {
    public boolean canHandle(HandlerInput handlerInput) {
        // Returns true if launch request
        return handlerInput.matches(Predicates.requestType(LaunchRequest.class));
    }

    public Optional<Response> handle(HandlerInput handlerInput) {
        String speechText = getRandomResponse();

        return handlerInput.getResponseBuilder()
                .withSpeech(speechText)
                .withSimpleCard("Dominic", speechText)
                .withShouldEndSession(true)
                .build();
    }

    private String getRandomResponse() {
        List<String> possibleAnswers = new ArrayList<>();
        possibleAnswers.add("<speak>Ich bin auf der Suche nach <prosody rate=\"slow\">wahrer</prosody> Liebe!</speak>");
        possibleAnswers.add("<speak>Das ist nicht schwarz, das ist <lang xml:lang=\"fr-FR\">Gelin</lang> farben!</speak>");
        possibleAnswers.add("Expertengruppen sind eh fuer den Arsch!");
        possibleAnswers.add("<speak>Meiner ist <lang xml:lang=\"de-DE\">laenger</lang> als deiner!</speak>");
        possibleAnswers.add("Ich bin schon ganz feucht...");
        possibleAnswers.add("<speak>Ich bin schon ganz <prosody rate=\"x-fast\">wuschig</prosody>!</speak>");
        possibleAnswers.add("Du bist halt kein Gewinnertyp - So wie ich!");
        possibleAnswers.add("Mit dir verlieren wir wenigstens niemand wertvolles!");
        possibleAnswers.add("Was interessiert mich dem sein gelaber");
        possibleAnswers.add("Das ist unschaetzbar - aber nicht wertvoll gemeint!");
        possibleAnswers.add("Ich goenn mir den langen Stab, weil ich auf lange Staebe stehe");
        possibleAnswers.add("Du bist wie ein einlagiges Toilettenpapier. Reicht zum Arsch abwischen, mehr aber auch nicht");
        possibleAnswers.add("Jeder will doch so eine schwarze Schlange");
        possibleAnswers.add("Na mein Butterkeks, darf ich dich zerbroeseln?");
        possibleAnswers.add("Manche trainieren nur Bizeps, ich trainiere Schließmuskel!");
        possibleAnswers.add("Prost ihr Saecke, Prost du Schamlippe!");
        possibleAnswers.add("Ich koche gerne und bei dir wuerde ich auch mal gerne meinen Spargel reinstecken!");
        possibleAnswers.add("Die Schlange windet sich schon!");
        possibleAnswers.add("Hoch die Haende, Samenspende");
        int randomNum = ThreadLocalRandom.current().nextInt(0, possibleAnswers.size());
        return possibleAnswers.get(randomNum);
    }
}
