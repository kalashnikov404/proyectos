import React from 'react';
import { render } from 'react-dom';
import { QRCode } from 'react-qr-svg';

const styles = {
  root: {
    fontFamily: 'sans-serif',
  },
  h1: {
    textAlign: 'center',
  },
  qrcode: {
    textAlign: 'center',
  },
};

export default class App extends React.Component {
  componentDidMount() {}

  render() {
    return (
      <div style={styles.root}>
        <h1 style={styles.h1}>QRCode with JSON</h1>
        <div style={styles.qrcode}>
          <QRCode
            level="Q"
            style={{ width: 256 }}
            value={JSON.stringify({
              cve_asp: 5,
              id: 7,
              insider: true,
            })}
          />
        </div>
      </div>
    );
  }
}

render(<App />, document.getElementById('root'));
