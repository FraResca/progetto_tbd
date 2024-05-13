describe('RisultatoForm Page', () => {
    beforeEach(() => {
        // Assuming you're serving your app locally on port 3000
        cy.visit('http://localhost:3000/risultatoEdit/6/1/1');
    });

    it('displays referto and prescr input fields', () => {
        cy.get('input[id="referto"]')
        cy.get('input[id="prescr"]')
        cy.get('.btn.btn-success').should('be.visible');
        cy.get('.btn.btn-danger').should('be.visible');
    });

    it('submits form with valid inputs', () => {
        cy.get('input[id="referto"]').type('Referto Test');
        cy.get('input[id="prescr"]').type('Prescrizione Test');
        cy.get('.btn.btn-success').click();

        cy.url().should('include', '/appuntamentiMedico');
    });

    it('does not navigate with incomplete inputs', () => {
        cy.get('input[id="referto"]').clear();
        cy.get('.btn.btn-success').click();
        cy.url().should('include', '/risultatoEdit/6/1/1');
    });

    it('navigates back when back button is clicked', () => {
        cy.get('.btn.btn-danger').click();
        cy.url().should('include', '/appuntamentiMedico');
    });
});