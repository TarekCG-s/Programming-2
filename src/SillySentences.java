
/*
 * 	<sentence> ::= <simple_sentence> [ <conjunction> <sentence> ]

	<simple_sentence> ::= <noun_phrase> <verb_phrase>

	<noun_phrase> ::= <proper_noun> | 
	<determiner> [ <adjective> ]. <common_noun> [ who <verb_phrase> ]

	<verb_phrase> ::= <intransitive_verb> | 
	<transitive_verb> <noun_phrase> |
	is <adjective> |
	believes that <simple_sentence>

	<conjunction> ::= and | or | but | because

	<proper_noun> ::= Fred | Jane | Richard Nixon | Miss America

	<common_noun> ::= man | woman | fish | elephant | unicorn

	<determiner> ::= a | the | every | some

	<adjective> ::= big | tiny | pretty | bald

	<intransitive_verb> ::= runs | jumps | talks | sleeps

	<transitive_verb> ::= loves | hates | sees | knows | looks for | finds
 */


/**
 * This class generates silly sentences randomly. Sentences will be grammatically correct, but they might not make any sense.
 * @author Tarek
 *
 */
public class SillySentences {

	private static final String[] properNouns = {"Fred" , "Jane", "Richard Nixon", "Miss America"};

	private static final String[] commonNouns = {"man" , "woman", "fish", "elephant", "unicorn"};

	private static final String[] intransVerbs = {"runs" , "jumps", "talks", "sleeps"};

	private static final String[] transVerbs = {"loves" , "hates", "sees", "knows", "looks for", "finds"};

	private static final String[] determiners = {"a" , "the", "every", "some"};

	private static final String[] adjectives = {"big" , "tiny", "pretty", "bald"};	

	private static final String[] conjunctions = {"and" , "or", "but", "because"};	

	public static int numSentences = 0; //number of constructed phrases in order to avoid having many sentences in a phrase.

	public static void main(String[] args) 
	{
		while (true) {
			SimpleSentence();
			System.out.println(".\n\n");
			numSentences = 0;
			
			try {
				Thread.sleep(3000);
			}
			catch (InterruptedException e) {
			}
		}
	}
	
	
	/**
	 * Generates simple sentences randomly.
	 */
	public static void SimpleSentence() 
	{
		numSentences++;

		NounPhrase();
		VerbPhrase();

		//Adds another sentence randomly.
		if(Math.random() > 0.75f && numSentences < 3) 
		{
			int conjunction = (int)(Math.random() * conjunctions.length);
			System.out.printf(" %s ",conjunctions[conjunction]);
			SimpleSentence();
		}
		return;
	}

	private static void NounPhrase() 
	{
		if(Math.random() > 0.5f) 
		{
			int properNoun = (int)(Math.random() * properNouns.length);
			System.out.printf("%s ",properNouns[properNoun]);
		}
		else 
		{
			int determiner = (int)(Math.random() * determiners.length);
			System.out.printf("%s ",determiners[determiner]);

			if(Math.random() > 0.25f) 
			{
				int adjective = (int)(Math.random() * adjectives.length);
				System.out.printf("%s ",adjectives[adjective]);
			}

			int commonNoun = (int)(Math.random() * commonNouns.length);
			System.out.printf("%s ",commonNouns[commonNoun]);

			if(Math.random() > 0.5f && numSentences < 3 ) 
			{
				System.out.print("- who ");
				VerbPhrase();
				System.out.print(" - ");
			}

		}	

	}

	private static void VerbPhrase() 
	{
		double probabilty = Math.random();

		if (probabilty < 0.25f) 
		{
			int intransVerb = (int)(Math.random() * intransVerbs.length);
			System.out.printf("%s",intransVerbs[intransVerb]);
		}

		else if (probabilty < 0.5f && numSentences < 3) 
		{
			int transVerb = (int)(Math.random() * transVerbs.length);
			System.out.printf("%s ",transVerbs[transVerb]);
			NounPhrase();
		}

		else if (probabilty < 0.75f && numSentences < 3) 
		{
			System.out.print("believes that ");
			SimpleSentence();			
		}

		else 
		{
			System.out.print("is ");

			int adjective = (int)(Math.random() * adjectives.length);
			System.out.printf("%s ",adjectives[adjective]);
		}

	}

}
