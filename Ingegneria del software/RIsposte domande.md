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