package org.makaia;

public enum Career {
    ENGINEER("INGENIERO"),
    DOCTOR("DOCTOR"),
    STUDENT("ESTUDIANTE"),
    CARPENTER("CARPINTERO"),
    VET("VETERINARIO");

    private String nameInSpanish;

    Career(String nameInSpanish) {
        this.nameInSpanish = nameInSpanish;
    }

    public String getNameInSpanish() {
        return nameInSpanish;
    }

}
