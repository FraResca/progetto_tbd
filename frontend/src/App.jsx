import './App.css'
import FooterComponent from './components/FooterComponent'
import HeaderComponent from './components/HeaderComponent'
import ListPazienteComponent from './components/admin/ListPazienteComponent'
import {BrowserRouter, Routes, Route} from 'react-router-dom'
import MenuComponent from './components/admin/MenuComponent'
import ListMedicoComponent from './components/admin/ListMedicoComponent'
import Homepage from './components/home/Homepage'
import VisualizzaPaziente from './components/viste/VisualizzaPaziente'
import VisualizzaMedico from './components/viste/VisualizzaMedico'
import VisualizzaVisita from './components/viste/VisualizzaVisita'
import VisualizzaCartella from './components/liste/VisualizzaCartella'
import VisualizzaCartellaMedico from './components/liste/VisualizzaCartellaMedico'
import VisualizzaCartellaAdmin from './components/liste/VisualizzaCartellaAdmin'
import AppuntamentiPaziente from './components/liste/AppuntamentiPaziente'
import MenuVisite from './components/liste/MenuVisite'
import ProfiloUtente from './components/viste/ProfiloUtente'
import ProfiloUtenteAdmin from './components/viste/ProfiloUtenteAdmin'
import AppuntamentiHr from './components/liste/AppuntamentiHr'
import AppuntamentiMedico from './components/liste/AppuntamentiMedico'
import ProfiloMedico from './components/viste/ProfiloMedico'
import ProfiloMedicoAdmin from './components/viste/ProfiloMedicoAdmin'
import AppuntamentoForm from './components/viste/AppuntamentoForm'
import PazienteLogin from './components/login/PazienteLogin'
import MedicoLogin from './components/login/MedicoLogin'
import AdminLogin from './components/login/AdminLogin'
import HrLogin from './components/login/HrLogin'
import ElencoSlot from './components/liste/ElencoSlot'
import RisultatoForm from './components/viste/RisultatoForm'

function App() {

  return (
    <>
      <BrowserRouter>
        <HeaderComponent />
        <Routes>
            {/* // http://localhost:3000 */}
            <Route path='/' element={<Homepage />}></Route>
            {/* // http://localhost:3000/hr */}
            <Route path='/menuComponent' element = { <MenuComponent />}></Route>
            {/* // http://localhost:3000/pazienti */}
            <Route path='/pazienti' element = { <ListPazienteComponent />}></Route>
            {/* // http://localhost:3000/add-paziente */}
            <Route path='/add-paziente' element = { <ProfiloUtente/> }></Route>
            {/* // http://localhost:3000/edit-paziente/1 */}
            <Route path='/edit-paziente/:id_paziente' element={<ProfiloUtente />}></Route>
            {/* // http://localhost:3000/medici */}
            <Route path='/medici' element = { <ListMedicoComponent />}></Route>
            {/* // http://localhost:3000/add-medico */}
            <Route path='/add-medico' element={<ProfiloMedico />}></Route>
            {/* // http://localhost:3000/edit-medico/1 */}
            <Route path='/edit-medico/:id_medico' element={<ProfiloMedico />}></Route>
            {/* // http://localhost:3000/admin-medico/1 */}
            <Route path='/admin-medico/:id_medico' element={<ProfiloMedicoAdmin />}></Route>
            {/* // http://localhost:3000/admin-utente/1 */}
            <Route path='/admin-utente/:id_paziente' element={<ProfiloUtenteAdmin />}></Route>
            {/* // http://localhost:3000/add-appuntamento */}
            <Route path='/add-appuntamento' element={<AppuntamentoForm />}></Route>
            {/* // http://localhost:3000/edit-appuntamento/1 */}
            <Route path='/edit-appuntamento/:id_appuntamento' element={<AppuntamentoForm />}></Route>
            {/* // http://localhost:3000/visualizzaPaziente/1 */}
            <Route path='/visualizzaPaziente/:idPaziente/:idMedico' element={<VisualizzaPaziente />}></Route>
            {/* // http://localhost:3000/visualizzaMedico/1 */}
            <Route path='/visualizzaMedico/:idMedico/:idPaziente' element={<VisualizzaMedico />}></Route>
            {/* // http://localhost:3000/visualizzaVisita/1 */}
            <Route path='/visualizzaVisita/:idVisita' element={<VisualizzaVisita />}></Route>
            {/* // http://localhost:3000/visualizzaCartella/1 */}
            <Route path='/visualizzaCartella/:idPaziente' element={<VisualizzaCartella />}></Route>
            {/* // http://localhost:3000/visualizzaCartellaMedico/1/1 */}
            <Route path='/visualizzaCartellaMedico/:idPaziente/:idMedico' element={<VisualizzaCartellaMedico />}></Route>
            {/* // http://localhost:3000/visualizzaCartellaAdmin/1 */}
            <Route path='/visualizzaCartellaAdmin/:idPaziente' element={<VisualizzaCartellaAdmin />}></Route>
            {/* // http://localhost:3000/appuntamentiPaziente/1 */}
            <Route path='/appuntamentiPaziente/:idPaziente' element={<AppuntamentiPaziente />}></Route>
            {/* // http://localhost:3000/menuVisite/1 */}
            <Route path='/menuVisite/:idPaziente' element={<MenuVisite />}></Route>
            {/* // http://localhost:3000/profiloUtente/1 */}
            <Route path='/profiloUtente/:idPaziente' element={<ProfiloUtente />}></Route>
            {/* // http://localhost:3000/profiloUtenteAdmin/1 */}
            <Route path='/profiloUtenteAdmin/:idPaziente' element={<ProfiloUtenteAdmin />}></Route>
            {/* // http://localhost:3000/appuntamentiHr */}
            <Route path='/appuntamentiHr' element={<AppuntamentiHr />}></Route>
            {/* // http://localhost:3000/appuntamentiMedico/1 */}
            <Route path='/appuntamentiMedico/:idMedico' element={<AppuntamentiMedico />}></Route>
            {/* // http://localhost:3000/loginPaziente */}
            <Route path='/loginPaziente' element={< PazienteLogin />}></Route>
            {/* // http://localhost:3000/loginMedico */}
            <Route path='/loginMedico' element={< MedicoLogin />}></Route>
            {/* // http://localhost:3000/loginAdmin */}
            <Route path='/loginAdmin' element={< AdminLogin />}></Route>
            {/* // http://localhost:3000/loginHr */}
            <Route path='/loginHr' element={< HrLogin />}></Route>
            {/* // http://localhost:3000/elencoSlot/1/1/1 */}
            <Route path='/elencoSlot/:idPaziente/:idMedico/:idVis' element={< ElencoSlot />}></Route>
            {/* // http://localhost:3000/risultatoForm/1/1 */}
            <Route path='/risultatoForm/:idApp/:idMedico' element={< RisultatoForm />}></Route>
            {/* // http://localhost:3000/risultatoEdit/1/1/1 */}
            <Route path='/risultatoEdit/:idApp/:idMedico/:idRis' element={< RisultatoForm />}></Route>

          </Routes>
        <FooterComponent />
      </BrowserRouter>
    </>
  )
}

export default App
