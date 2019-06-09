# Domanda tecnica su chi implementa cosa in un pattern visitors
Il pattern VISITOR permette di definire una nuova operazione da effettuare su gli elementi di una struttura, senza dover modificare le classi degli elementi coinvolti.
Si consideri un *abstract syntax tree* (AST) - un albero in cui i nodi descrivono elementi sintattici del programma. 
Su questo albero devono esserci una lista di operazioni consentite utilizziamo il pattern *composite*.
Se successivamente vogliamo aggiungere altre operazioni sfruttiamo il pattern VISITOR. La soluzione è quella di eliminare le singole operazioni dall?AST e tutto il codice relativo ad un singolo tipo di operazione viene raccolto in una singola classe. I nodi dell'AST accettano la visita delle istanze delle nuove classi (**visitor**). Ne viene che per aggiungere un nuovo tipo di operazione basta progettare una nuova classe.

![](resources/visitor_1.png)

Ogni nodo deve dichairare un'operazione per accettare un generico visitor

![resources/visitor_2.png](resources/visitor_2.png)

-   **Visitor** -> Classe astratta o interfaccia
    -   Dichiara un metodo ***visit*** per ogni classe di elementi concreti
-   **ConcreteVisitor**
    -   Definisce tutti i metodi ***Visit***
    -   Globalmente definisce l'operazione da effettuare sulla struttura

![](resources/visitor_3.png)

-   **Element** -> Classe astratta o interfaccia
    -   Dichiara un metodo ***Accept*** che accetta un visitor come argomento
-   **ConcreteElement**
    -   Definisce il metodo ***Accept***

![](resources/visitor_4.png)

Object structure può essere realizzato come composite o come normale collezzione (array, lista ...)

In sintesi il pattern VISITOR:
-   Faciclita l'aggiunta di nuove operazioni
-   Ogni visitor concreto
    -   Raggruppa i metodi necessare ad eseguire una data operazione
    -   Nasconde i dettagli di come tale operazione debba essere eseguita

# Quali sono i pattern comportamentali, quali costruttivi e quali strutturali
![](resources/pattern_1.png)

(trucchetto: A-F sono strutturali / G-Z sono comportamentali / Factory e Singleton sono Creazionali)

# Domanda su .net assembly (Come funzionano) , metadati
## Il .NET assembly
-   E' l'unità minima per la distribuzione e il versioning
-   Normalmente è composto da un solo file
-   Può essere composta da più file (Module)

![](resources/assembly_1.png)

## I metadati
-   Descrrivono l'assembly - Manifest
    -   Identità: nome, versione, cultura
    -   Lista dei file che compongono l'assembly
    -   Riferimenti ad altri assembly da cui si dipende
    -   Permessi necessari per l'esecuzione
-   Descrizione dei tipi contenuti nell'assembly
    -   Nome, visibilità, classe base, interfacce
    -   Campi, metodi, proprietà, eventi
    -   Attributi
        -   Definiti dal compilatore
        -   Definiti dal framework
        -   Definiti dall'utente

![](resources/assembly_2.png)

# Domanda su cls di .net
Il **Common Language Specification**
-   Definisce le regole di compatibilità tra linguaggi
    -   Regole per gli identificatori
        -   Unicode, case-sensitivity
        -   Keyword
    - Regole per denominazione proprietà ed eventi
    - Regole per costruttori degli oggetti
    - Regole di overload più restrittive
    - Ammesse interfacce multiple con metodi con lo stesso nome
    - Non ammessi puntatori unmanaged

![](resources/cls_1.png)

-   Regole
    - Information hiding a livello di assembly
    - Information hiding a livello di classe
    - Information hiding a livello di field
-   Costanti: il nome dovrebbe iniziare con una lettera maiuscola e solitamente deve essere pubblica
-   Field: il nome deve iniziare con ‘_’ seguito da lettera minuscola e deve essere privato
-   Field read-only: une delle due convenzioni precedenti

# Dire di che tipo deve essere il type di un event

# Pattern FLyWeight
Il FlyWeight è un pattern **Strutturale**.
-   Descrive come condividere oggetti *leggeri* in modo tale che il loro uso non sia troppo costoso
-   E' un oggetto condiviso utilizzabile simultaneamente da più clienti.
-   E' svincolato dal contesto in cui opera
-   E' ottenibile soltanto mediante una **FlyweightFactory**

**Stato intrinseco**
-   Non dipende dal contesto di utilizzo e quindi può essere condiviso da tutti i clienti
-   E' memorizzato nel Flyweight

**Stato estrinseco**
-   Dipende dal contesto di utilizzo e quindi non può essere condiviso dai clienti
-   Calcolato dal cliente
-   Viene passato al Flyweight quando viene invocat una sua operazione

![](resources/flyweight_1.png)

# Pattern che usano la delega
-   **Boss-worker** offre una soluzione ***delegate-based*** *callback_relationship*
-   L' ***AlignerBase*** del pattern **Strategy** delega alle sue sottoclassi l'allineamendot delle singole linee
-   Nel pattern **Decorator** quando un oggetto cambia stato, cambia anche comportamento utilizzando un pattern **State** che utilizza un meccanismo di delega, grazie al quale l'oggetto è in grado di comportarsi come se avesse cambiato classe.

# Quale pattern NON usa la composizione e delega
I pattern che utilizzano Adapter e che non utilizzano Composite e Decorator
-   Pattern **Observer** (?)

# Domanda sui rischi tecnologici
## Analisi e gestione dei rischi
-   Analisi completa di tutti i possibili rischi che posso fare fallori o intralciare la realizzazione del sistema
-   Ogni rischio presenta due carratteristiche:
    -   Probabilità che avvenga
    -   Costo

Le tipologie di rischi sono:
-   **Rischi relativi ai requisiti**
-   **Rischi relativi alle risorse umane**
-   **Rischi relativi alla protezione e privacy dei dati**
-   **Rischi tecnologici** :
    -   
-   **Rischi politici**

Strategie risolutive:
-   **Strategia reattiva**
-   **Strategia preventiva**
    -   Si mette in moto prima che inizi il lavoro tecnico
    -   Si individuano rischi potenziali, se ne valutano le probabilità e si stabilisce un ordine di importanza
    -   Si predispone un piano che permetta di reagire in modo controllato ed efficace.

# Definizione di design pattern
*"Each pattern describes a problem which occurs over and over again in our environment, and then describes the core of the solution to that problem, in such a way that you can use the olution a million times over, without ever doing it the same way twice"*
1977 - Christoper Alexander
**Obiettivi**
-   Risolvere problemi progettuali specifici
-   Rendere i progetti OO più flessibili e riutilizzabili

Ogni design pattern ha quattro elementi essenziali
-   **Nome** - Identifica il pattern
-   **Problema** - Descrive quando applicare il pattern
-   **Soluzinoe** - Descrive il pattern, cioè gli elementi che lo compongono e le loro relazioni, responsabilità e collaborazioni.
-   **Conseguenze** - Descrivono svantaggi e vantaggi dell'applicazione del pattern.

Sono classificati in
-   **Pattern di creazione** - Risolvono problemi inerenti il processo di creazione degli oggetti
-   **Pattern strutturali** - Risolvono problemi inerenti la composizione di classi o di oggetti.
-   **Pattern comportamentali** - Risolvono problemi inerenti le modalità di interazione e di distribuzione delle responsabilità tra classi o tra oggetti.

![](resources/pattern_1.png)

# Scopo del modello evolutivo
## Modelli evolutivi

### Programmazione esplorativa
Il prototipo, progressivamente, fluisce nel prodotto finale.
Questo presuppone un lavoro a stretto contatto con il cliente.

Esistono diversi tipo di modelli evolutivi, ma tutti in sostanza propongono un ciclo di sviluppo in cui un prototipo iniziale evolve, gradualmente, verso il prodotto finito.
Il vantaggio è che ad ogni iterazione è possibile :
- ***Raffinamento dell'analisi*** : rivedere specifiche e funzionalità.
- ***Raffinamento del design*** : rivedere le scelte di progettazione.
- I modelli evolutivi si sono orientati verso cicli sempre più
brevi e iterazioni sempre più veloci, fino ad arrivare al
modello più “radicale” che prende il nome di Extreme
Programming (XP)

### Applicabilità
-   Sitstemi di piccoli dimensioni
-   Sistemi che avranno breve durata
-   Parti di sistemi più grandi

### Problemi dei modelli evolutivi
-   Il processo di sviluppo non è visibile.
-   Il sistema è poco strutturato.
-   E' richiesta una particolare abilità nella programmazione.