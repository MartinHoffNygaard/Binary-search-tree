# Obligatorisk oppgave 3 i Algoritmer og Datastrukturer

Denne oppgaven er en innlevering i Algoritmer og Datastrukturer. 
Oppgaven er levert av følgende student:
* Martin Hoff Nygaard, S362081, s362081@oslomet.no


# Oppgavebeskrivelse

I oppgave 1 så gikk jeg frem ved å kopiere inn programkode 5.2.3 a) fra kompendiet. Det som måtte endres i koden fra 
kompendiet var å passe på at det ble en peker til foreldrenode når man legger inn en ny node. Dette løste jeg ved å endre
opprettelsen av den nye noden til å inneholde noden q som foreldrenode. Dette funker fordi q alltid er forelderen til p og 
om det ikke er noen noder fra før så blir p rotnode og q er da null. Jeg la også til slik at endringer blir oppdatert når 
det legges inn en ny node. 

I oppgave 2 så lagde jeg først en hjelpevariabel som teller antall forekomster vi finner av verdien. Jeg lagde også en sjekk
for om verdien er null siden da kan vi bare returnere 0 med en gang. Jeg brukte en while løkke for å traversere gjennom 
treet fra rotnoden. Jeg brukte en comparator til å sammenligne verdien med verdien i en node, om den er mindre så går traverseringen
videre til venstre barn og til høyre barn om den er større. Om verdiene er like så blir det telt i telleren jeg har laget 
og traverseringen fortsetter videre til høyre barn i tilfelle det er flere forekomster av verdien som da vil ligge til høyre
for noden. 

I oppgave 3 så kodet jeg førstePostorden til å traversere gjennom treet helt til vi er på den bladnoden som er lengst til 
venstre i treet. Dette er noden som blir først i postorden. I nestePostorden så sjekker jeg først om input noden er en rot
node fordi da finnes det ikke en neste ettersom rotnoden er siste noden i postorden. Deretter sjekker jeg om forelderen 
til noden har ett høyre barn og at dette ikke er noden selv. Om det er tilfellet så er forelderen neste noden i postorden. 
Dersom det finnes ett høyrebarn så bruker jeg førstePostorden metoden på subtreet med den høyre barnet som rot til å finne
neste node i postorden. 

I oppgave 4 så kodet jeg den postorden metoden ved å bruke en while løkke. Metoden starter på den første noden i postorden 
og utfører oppgaven på noden. Deretter traverserer metoden seg videre i treet ved hjelp av nestepostorden metoden og fortsetter 
å utføre oppgaven på de neste i postorden. Når traverseringen har beveget seg utenfor treet så stopper while løkken. 
PostordenRecursive kodet jeg ved å sette basistilfelle til når vi har traveresert utenfor treet. Det gjøres ett enklere 
rekursivt kall først på det venstre barnet til node så på det høyre barnet til noden. Når det rekursive kallet når den neste 
noden i postorden så utføres oppgaven. 

I oppgave 5 lagde jeg metoden serialize() ved å bruke ett deque som en kø. I køen så blir først rotnoden lagt til. Deretter 
så er det en while løkke som går så lenge køen ikke er tom. Inne i while løkken så blir først den første noden i køen fjernet
og verdien til denne noden blir lagret i output arrayet. Deretter så legges det høyre og venstre barnet til noden til i 
køen dersom de finnes. I metoden deserialize så lages det først ett binært søketre, så bruker jeg leggInn metoden til å 
legge til verdiene fra input arrayet. Looper gjennom verdiene til inputarrayet med en løkke. 

I oppgave 6 så startet jeg med å lage fjern metoden. Her kopierte jeg programkode 5.2.8 d) fra kompendiet og la til oppdatering
av foreldre node der det trengtes. I fjernAlle metoden så bruker jeg en while løkke som kaller på fjern metoden så lenge 
fjern metoden klarte å fjerne en verdi tidligere. Hver gang en verdi fjernes så oppdateres en teller som til slutt blir
returnert. I nullstill metoden så traverserer metoden gjennom treet i postorden og sletter alle noder på veien. Til slutt
slettes rot noden fordi den er siste noden i postorden. 
