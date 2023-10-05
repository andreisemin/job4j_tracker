package ru.job4j.queue;

import java.util.Deque;
import java.lang.StringBuilder;

public class ReconstructPhrase {
    private final Deque<Character> descendingElements;

    private final Deque<Character> evenElements;

    public ReconstructPhrase(Deque<Character> descendingElements, Deque<Character> evenElements) {
        this.descendingElements = descendingElements;
        this.evenElements = evenElements;
    }

    private String getEvenElements() {
        StringBuilder builder = new StringBuilder();
        int size = evenElements.size();
        for (int index = 0; index < size; index++) {
            if (index % 2 == 0) {
                builder.append(evenElements.peek());
            }
            evenElements.pollFirst();
        }
        return builder.toString();
    }

    private String getDescendingElements() {
        StringBuilder builder = new StringBuilder();
        int size = descendingElements.size();
        for (int index = 0; index < size; index++) {
            builder.append(descendingElements.pollLast());
        }
        return builder.toString();
    }

    public String getReconstructPhrase() {
        return getEvenElements() + getDescendingElements();
    }
}
