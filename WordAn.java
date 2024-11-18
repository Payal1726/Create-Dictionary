import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;       
import java.util.Scanner;  

public class WordAn {

    private static List<String> dictionary = new ArrayList<>();
    private static Map<String, String> wordMeanings = new HashMap<>();
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        populateDictionary();  
        
        boolean continueFlag = true;
        while (continueFlag) {
            System.out.println("Enter a word:");
            String userInput = sc.nextLine().toLowerCase();
            
            System.out.println("Choose an option:");
            System.out.println("1. Find related words");
            System.out.println("2. Get the meaning of the word");
            int choice = sc.nextInt();
            sc.nextLine();  // Consume the newline left by nextInt()
            
            switch (choice) {
                case 1:
                    // Find related words (suggestions)
                    List<String> suggestions = findTop3Suggestions(userInput);
                    if (suggestions.isEmpty()) {
                        System.out.println("No similar words found.");
                    } else {
                        System.out.println("Did you mean: " + suggestions);
                    }
                    break;
                case 2:
                    // Find the meaning of the word
                    if (wordMeanings.containsKey(userInput)) {
                        System.out.println("Meaning of " + userInput + ": " + wordMeanings.get(userInput));
                    } else {
                        System.out.println("Word not found in dictionary.");
                    }
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
                    break;
            }

            // Ask if the user wants to continue
            System.out.println("Do you want to continue? (yes/no)");
            String continueInput = sc.nextLine().toLowerCase();
            if (!continueInput.equals("yes")) {
                continueFlag = false;
                System.out.println("Exiting the program.");
            }
        }
        sc.close();
    }

    // Method to populate dictionary with words and meanings
private static void populateDictionary() {
    dictionary.addAll(Arrays.asList(
        "achieve", "advise", "analyze", "arrange", "assist", "attend", "balance",
        "benefit", "calculate", "capture", "change", "clarify", "collaborate", 
        "communicate", "compare", "complete", "compose", "conclude", "create",
        "decide", "define", "delegate", "demonstrate", "develop", "discover", 
        "discuss", "distribute", "document", "edit", "educate", "eliminate", 
        "encourage", "enhance", "evaluate", "execute", "expand", "explore", 
        "facilitate", "focus", "formulate", "gather", "generate", "identify", 
        "implement", "improve", "influence", "instruct", "integrate", 
        "interact", "investigate", "lead", "maintain", "manage", "monitor", 
        "motivate", "negotiate", "observe", "organize", "outline", "participate", 
        "perform", "plan", "prioritize", "produce", "promote", "protect", 
        "provide", "publish", "recommend", "refine", "report", "research", 
        "respond", "review", "schedule", "simplify", "solve", "strategize", 
        "support", "sustain", "synthesize", "teach", "test", "track", 
        "train", "transmit", "transform", "utilize", "validate", "verify", 
        "visualize", "innovate", "adapt", "execute"
    ));

    // Adding meanings with synonyms
    wordMeanings.put("achieve", "Synonym: attain. Meaning: To successfully reach a desired objective or result.");
    wordMeanings.put("advise", "Synonym: counsel. Meaning: To offer suggestions about the best course of action.");
    wordMeanings.put("analyze", "Synonym: examine. Meaning: To examine in detail for purposes of explanation and interpretation.");
    wordMeanings.put("arrange", "Synonym: organize. Meaning: To put things in a proper order or plan.");
    wordMeanings.put("assist", "Synonym: help. Meaning: To provide support or aid to someone.");
    wordMeanings.put("attend", "Synonym: participate. Meaning: To be present at an event or activity.");
    wordMeanings.put("balance", "Synonym: equilibrium. Meaning: To maintain stability or equal distribution.");
    wordMeanings.put("benefit", "Synonym: advantage. Meaning: An advantage gained from something.");
    wordMeanings.put("calculate", "Synonym: compute. Meaning: To determine mathematically or through calculation.");
    wordMeanings.put("capture", "Synonym: seize. Meaning: To take possession or control of something.");
    wordMeanings.put("change", "Synonym: alter. Meaning: To make or become different.");
    wordMeanings.put("clarify", "Synonym: elucidate. Meaning: To make clear or easier to understand.");
    wordMeanings.put("collaborate", "Synonym: cooperate. Meaning: To work jointly with others, especially in an intellectual endeavor.");
    wordMeanings.put("communicate", "Synonym: convey. Meaning: To share or exchange information, news, or ideas.");
    wordMeanings.put("compare", "Synonym: contrast. Meaning: To examine the similarities and/or differences.");
    wordMeanings.put("complete", "Synonym: finish. Meaning: To make something whole or full.");
    wordMeanings.put("compose", "Synonym: create. Meaning: To form by putting together parts or elements.");
    wordMeanings.put("conclude", "Synonym: deduce. Meaning: To arrive at a judgment or opinion by reasoning.");
    wordMeanings.put("create", "Synonym: produce. Meaning: To bring something into existence.");
    wordMeanings.put("decide", "Synonym: determine. Meaning: To come to a resolution or conclusion.");
    wordMeanings.put("define", "Synonym: describe. Meaning: To state the exact meaning of a word or concept.");
    wordMeanings.put("delegate", "Synonym: assign. Meaning: To entrust a task or responsibility to another.");
    wordMeanings.put("demonstrate", "Synonym: illustrate. Meaning: To show how something works or is done.");
    wordMeanings.put("develop", "Synonym: evolve. Meaning: To grow or cause to grow and become more mature.");
    wordMeanings.put("discover", "Synonym: find. Meaning: To uncover or reveal something previously unknown.");
    wordMeanings.put("discuss", "Synonym: debate. Meaning: To talk about something in order to reach a decision.");
    wordMeanings.put("distribute", "Synonym: allocate. Meaning: To give out or spread something over an area.");
    wordMeanings.put("document", "Synonym: record. Meaning: To create a record of something in written form.");
    wordMeanings.put("edit", "Synonym: revise. Meaning: To prepare written material for publication by correcting and organizing it.");
    wordMeanings.put("educate", "Synonym: teach. Meaning: To provide instruction or education.");
    wordMeanings.put("eliminate", "Synonym: remove. Meaning: To completely remove or get rid of something.");
    wordMeanings.put("encourage", "Synonym: motivate. Meaning: To give support, confidence, or hope.");
    wordMeanings.put("enhance", "Synonym: improve. Meaning: To increase or improve in quality, value, or extent.");
    wordMeanings.put("evaluate", "Synonym: assess. Meaning: To judge or determine the significance, worth, or quality.");
    wordMeanings.put("execute", "Synonym: perform. Meaning: To carry out or put into effect.");
    wordMeanings.put("expand", "Synonym: increase. Meaning: To increase in size, number, or importance.");
    wordMeanings.put("explore", "Synonym: investigate. Meaning: To travel through an unfamiliar area to learn about it.");
    wordMeanings.put("facilitate", "Synonym: assist. Meaning: To make an action or process easier.");
    wordMeanings.put("focus", "Synonym: concentrate. Meaning: To direct attention or effort toward a specific area.");
    wordMeanings.put("formulate", "Synonym: devise. Meaning: To create or prepare methodically.");
    wordMeanings.put("gather", "Synonym: collect. Meaning: To bring together or assemble.");
    wordMeanings.put("generate", "Synonym: produce. Meaning: To bring into existence; create.");
    wordMeanings.put("identify", "Synonym: recognize. Meaning: To establish or indicate who or what someone or something is.");
    wordMeanings.put("implement", "Synonym: execute. Meaning: To put a decision, plan, or agreement into effect.");
    wordMeanings.put("improve", "Synonym: enhance. Meaning: To make or become better.");
    wordMeanings.put("influence", "Synonym: affect. Meaning: To have an effect on the character or development of someone or something.");
    wordMeanings.put("instruct", "Synonym: teach. Meaning: To direct or command someone to do something.");
    wordMeanings.put("integrate", "Synonym: incorporate. Meaning: To combine one thing with another so they become a whole.");
    wordMeanings.put("interact", "Synonym: engage. Meaning: To act in such a way as to have an effect on another.");
    wordMeanings.put("investigate", "Synonym: examine. Meaning: To carry out a systematic inquiry to discover facts.");
    wordMeanings.put("lead", "Synonym: guide. Meaning: To be in charge or command of something.");
    wordMeanings.put("maintain", "Synonym: preserve. Meaning: To keep something in a particular state or condition.");
    wordMeanings.put("manage", "Synonym: oversee. Meaning: To be in charge of or control something.");
    wordMeanings.put("monitor", "Synonym: observe. Meaning: To watch and check the progress of something.");
    wordMeanings.put("motivate", "Synonym: inspire. Meaning: To provide someone with a reason for doing something.");
    wordMeanings.put("negotiate", "Synonym: bargain. Meaning: To try to reach an agreement or compromise.");
    wordMeanings.put("observe", "Synonym: watch. Meaning: To notice or perceive something.");
    wordMeanings.put("organize", "Synonym: arrange. Meaning: To arrange into a structured whole.");
    wordMeanings.put("outline", "Synonym: summarize. Meaning: To give a brief account of something, outlining its main points.");
    wordMeanings.put("participate", "Synonym: engage. Meaning: To take part in an activity or event.");
    wordMeanings.put("perform", "Synonym: execute. Meaning: To carry out a task or action.");
    wordMeanings.put("plan", "Synonym: scheme. Meaning: To think ahead about what to do in the future.");
    wordMeanings.put("prioritize", "Synonym: rank. Meaning: To arrange or deal with in order of importance.");
    wordMeanings.put("produce", "Synonym: create. Meaning: To bring into existence; make.");
    wordMeanings.put("promote", "Synonym: advance. Meaning: To support or actively encourage a cause or aim.");
    wordMeanings.put("protect", "Synonym: safeguard. Meaning: To keep safe from harm or injury.");
    wordMeanings.put("provide", "Synonym: supply. Meaning: To supply someone with something.");
    wordMeanings.put("publish", "Synonym: issue. Meaning: To prepare and issue for public distribution.");
    wordMeanings.put("recommend", "Synonym: suggest. Meaning: To put forward something as being suitable or good.");
    wordMeanings.put("refine", "Synonym: improve. Meaning: To remove impurities or unwanted elements from something.");
    wordMeanings.put("report", "Synonym: inform. Meaning: To give a spoken or written account of something.");
    wordMeanings.put("research", "Synonym: investigate. Meaning: To investigate systematically.");
    wordMeanings.put("respond", "Synonym: reply. Meaning: To answer back or react to something.");
    wordMeanings.put("review", "Synonym: assess. Meaning: To examine or assess something critically.");
    wordMeanings.put("schedule", "Synonym: timetable. Meaning: To arrange for something to happen at a specific time.");
    wordMeanings.put("simplify", "Synonym: clarify. Meaning: To make something easier to understand or do.");
    wordMeanings.put("solve", "Synonym: resolve. Meaning: To find an answer or solution to a problem.");
    wordMeanings.put("strategize", "Synonym: plan. Meaning: To devise a strategy or plan of action.");
    wordMeanings.put("support", "Synonym: assist. Meaning: To bear all or part of the weight of something.");
    wordMeanings.put("sustain", "Synonym: maintain. Meaning: To support or prolong something.");
    wordMeanings.put("synthesize", "Synonym: combine. Meaning: To combine different elements into a coherent whole.");
    wordMeanings.put("teach", "Synonym: educate. Meaning: To impart knowledge or skill.");
    wordMeanings.put("test", "Synonym: assess. Meaning: To evaluate something by conducting an experiment or trial.");
    wordMeanings.put("track", "Synonym: follow. Meaning: To monitor the progress or development of something.");
    wordMeanings.put("train", "Synonym: instruct. Meaning: To teach a person or animal a particular skill or type of behavior.");
    wordMeanings.put("transmit", "Synonym: transfer. Meaning: To send or convey something from one place to another.");
    wordMeanings.put("transform", "Synonym: convert. Meaning: To make a thorough or dramatic change in form or appearance.");
    wordMeanings.put("utilize", "Synonym: use. Meaning: To make practical or effective use of something.");
    wordMeanings.put("validate", "Synonym: confirm. Meaning: To check or prove the accuracy of something.");
    wordMeanings.put("verify", "Synonym: authenticate. Meaning: To establish the truth or correctness of something.");
    wordMeanings.put("visualize", "Synonym: imagine. Meaning: To form a mental image of something.");
    wordMeanings.put("innovate", "Synonym: invent. Meaning: To make changes in something established, especially by introducing new methods.");
    wordMeanings.put("adapt", "Synonym: adjust. Meaning: To modify or adjust to new conditions.");
    wordMeanings.put("execute", "Synonym: implement. Meaning: To carry out a task or plan successfully.");
}


    // Method to find top 3 similar words based on character comparison
    private static List<String> findTop3Suggestions(String input) {
        Map<String, Integer> similarityMap = new HashMap<>();

        // Compare input with each word in the dictionary
        for (String word : dictionary) {
            int similarityScore = calculateLevenshteinDistance(input, word);
            similarityMap.put(word, similarityScore);
        }

        // Sort the dictionary by similarity score (ascending order)
        List<Map.Entry<String, Integer>> sortedList = new ArrayList<>(similarityMap.entrySet());
        sortedList.sort(Comparator.comparingInt(Map.Entry::getValue));

        // Extract the top 3 most similar words
        List<String> topSuggestions = new ArrayList<>();
        for (int i = 0; i < Math.min(3, sortedList.size()); i++) {
            topSuggestions.add(sortedList.get(i).getKey());
        }

        return topSuggestions;
    }

    // Method to calculate Levenshtein Distance  
    //Dynamic programming 
    private static int calculateLevenshteinDistance(String a, String b) {
        int[][] dp = new int[a.length() + 1][b.length() + 1];
        for (int i = 0; i <= a.length(); i++) dp[i][0] = i;
        for (int j = 0; j <= b.length(); j++) dp[0][j] = j;

        for (int i = 1; i <= a.length(); i++) {
            for (int j = 1; j <= b.length(); j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1), dp[i - 1][j - 1] + 1);
                }
            }
        }
        return dp[a.length()][b.length()];
    }
}        


