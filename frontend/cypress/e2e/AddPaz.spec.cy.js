describe('Add Paziente Page', () => {
    beforeEach(() => {
        cy.visit('http://localhost:3000/add-paziente');
    });

    it('displays add paziente form', () => {
        cy.get('input[id="firstname"]').type('Mario');
        cy.get('input[id="lastname"]').type('Rossi');
        cy.get('input[id="date"]').type('1980-01-01');
        cy.get('input[id="email"]').type('mario.rossi@example.com');
        cy.get('input[id="password"]').type('1234');
        cy.get('input[id="cf"]').type('RSSMRA80A01H501A');

        cy.get('.btn.btn-success').should('be.visible');
    });

    it('can add paziente with correct credentials', () => {
        cy.get('input[id="firstname"]').type('Mario');
        cy.get('input[id="lastname"]').type('Rossi');
        cy.get('input[id="date"]').type('1980-01-01');
        cy.get('input[id="email"]').type('mario.ossi@example.com');
        cy.get('input[id="password"]').type('1234');
        cy.get('input[id="cf"]').type('RSSMRA90A01H501A');

        cy.get('.btn.btn-success').click();

        cy.url().should('include', '/appuntamentiPaziente');
    });

    it('does not navigate with incomplete credentials', () => {
        cy.get('.btn.btn-success').click();
        cy.url().should('include', '/add-paziente');
    });
});