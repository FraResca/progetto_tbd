describe('AppuntamentoForm Page', () => {
    beforeEach(() => {
        cy.visit('http://localhost:3000/add-appuntamento');
    });

    it('displays appuntamento form', () => {
        cy.get('input[id="paziente"]').type('Mario');
        cy.get('input[id="medico"]').type('Rossi');
        cy.get('input[id="visita"]').type('Visita Test');
        cy.get('input[id="slot"]').type('Slot Test');

        cy.get('.btn.btn-success').should('be.visible');
    });

    it('can add appuntamento with correct credentials', () => {
        cy.get('input[id="paziente"]').type('Mario');
        cy.get('input[id="medico"]').type('Rossi');
        cy.get('input[id="visita"]').type('Visita Test');
        cy.get('input[id="slot"]').type('Slot Test');

        cy.get('.btn.btn-success').click();

        cy.url().should('include', '/appuntamentiHr');
    });

    it('does not navigate with incomplete credentials', () => {
        cy.get('.btn.btn-success').click();
        cy.url().should('include', '/add-appuntamento');
    });
});