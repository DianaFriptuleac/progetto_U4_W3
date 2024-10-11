Strategia JOINED:
Ho scelto questa strategia perché mi permette di mantenere una buona normalizzazione dei dati nel database. 
Con JOINED, le classi derivate come Libri e Riviste sono memorizzate in tabelle separate ma condividono gli attributi comuni attraverso la tabella Catalogo.
In questo modo riduco la duplicazione di dati e rendo il database più efficiente, mantenendo le relazioni tra gli oggetti ben strutturate.

ManyToOne con JoinColumn:
Ho scelto questa strategia per collegare Prestito a Utente e Catalogo perche mi consente di rappresentare chiaramente la relazione tra i prestiti e gli utenti,
così come tra i prestiti e gli elementi del catalogo. 
Ogni prestito può riferirsi a un singolo utente e a un singolo elemento del catalogo.

OneToMany con Cascade e OrphanRemoval:
Questa mi facilita la gestione delle relazioni tra Utente e Prestito. 
Utilizzando CascadeType.ALL posso garantire che tutte le operazioni sugli utenti (come la rimozione o l'aggiornamento) 
si riflettano automaticamente sui prestiti associati. Ciò mantiene l'integrità dei dati e mi riduce il rischio di inconsistenze.

NamedQuery: Ho definito delle NamedQuery per ottimizzare e centralizzare le ricerche comuni,
come la ricerca di libri per autore o la ricerca di cataloghi per titolo. 
