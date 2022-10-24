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
