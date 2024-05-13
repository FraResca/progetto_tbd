describe('ProfMed Page', () => {
    beforeEach(() => {
        // Assuming you're serving your app locally on port 3000
        cy.visit('http://localhost:3000/edit-paziente/1');
    });

    it('displays add paziente form', () => {
        cy.get('input[id="firstname"]')
        cy.get('input[id="lastname"]')
        cy.get('input[id="date"]')
        cy.get('input[id="email"]')
        cy.get('input[id="password"]')
        cy.get('input[id="cf"]')
        cy.get('.btn.btn-success').should('be.visible');
    });

    it('updates paziente with changes', () => {
        cy.get('input[id="firstname"]').type('Mario');
        cy.get('input[id="lastname"]').type('Rossi');
        cy.get('input[id="date"]').type('1980-01-01');
        cy.get('input[id="email"]')
        cy.get('input[id="password"]')
        cy.get('input[id="cf"]')
        cy.get('.btn.btn-success').click();

        cy.url().should('include', '/appuntamentiPaziente');
    });

    it('does not navigate with incomplete credentials', () => {
        cy.get('input[id="lastname"]').clear();
        cy.get('.btn.btn-success').click();
        cy.url().should('include', '/edit-paziente/1');
    });
});