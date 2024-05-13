describe('Admin Login Page', () => {
    beforeEach(() => {
      // Assuming you're serving your app locally on port 3000
      cy.visit('http://localhost:3000/loginAdmin');
    });
  
    it('displays login form', () => {
      cy.get('form').should('be.visible');
      cy.get('input[id="password"]').should('be.visible');
      cy.get('.btn.btn-success').should('be.visible');
    });
  
    it('can log in with correct credentials', () => {
      cy.get('input[id="password"]').type('admin');
      cy.get('.btn.btn-success').click();
  
      cy.url().should('include', '/MenuComponent');
    });
  
    it('does not navigate with wrong credentials', () => {
      cy.get('input[id="password"]').type('wrongpassword');
      cy.get('.btn.btn-success').click();
      cy.url().should('include', '/loginAdmin');
    });
  });