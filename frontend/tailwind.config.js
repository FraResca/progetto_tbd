/** @type {import('tailwindcss').Config} */
export default {
  content: ["./index.html","./src/**/*.{js,jsx,ts,tsx}"],
  theme: {
          extend: {
              gridTemplateRows: {
                  '[auto,auto,1fr]': 'auto auto 1fr',
              },
          },
      },
      plugins: [
          
      ],
}


