JC=javac
JVM=java

.SUFFIXES: .java .class
.java.class:
	$(JC) -implicit:none -encoding utf-8 $*.java 

#----------------------------------------------

CLASSES= \
		Main.java \
		AccueilEvenement.java \
		AccueilMenu.java \
		MenuJouerPrincipal.java \
		MenuJouerPrincipalEvent.java \
		Algorithme.java \
		CheckGrille.java \
		DesignCase.java \
		DifficulteGrille.java \
		DifficulteGrilleEvent.java \
		Grille.java \
		Jeu.java \
		JeuEvent.java \
		JTextFieldLimit.java \
		LectureGrille.java \
		SauvegarderGrille.java \
		SelectMode.java \
		SelectModeEvent.java \
		TypeGrille.java \
		TypeGrilleEvent.java 


#----------------------------------------------

default: classes

classes: $(CLASSES:.java=.class)

run:
	$(JVM) Main
clean :
	$(RM) *.class