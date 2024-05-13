import React from 'react'
import {Grid, Typography } from '@mui/material'

const FooterComponent = () => {
  return (
      <div>
          <Grid className='bg-black text-white text-center' container sx={{bgcolor:"black",color:"white",py:3} }>
              <Grid className='pt-30' item xs={12}>
              <Typography variant="body2" componet="p" align="center">
                2023 All right reserved
              </Typography>
              <Typography variant="body2" componet="p" align="center">
                   By
              </Typography>
              <Typography variant="body2" componet="p" align="center">
                  Savonuzzi & Resca
              </Typography>
          </Grid>
        </Grid>
      </div>
  )
}

export default FooterComponent