import React from 'react';
import { View, Text, StyleSheet, TouchableOpacity, ScrollView } from 'react-native';

const DashboardScreen = ({ route, navigation }) => {
  const { user } = route.params || { user: 'Usuário' };

  const features = [
    { id: 1, label: 'Nova Ordem de Serviço' },
    { id: 2, label: 'Veículos' },
    { id: 3, label: 'Clientes' },
    { id: 4, label: 'Peças / Estoque' },
    { id: 5, label: 'Relatórios' },
  ];

  return (
    <ScrollView contentContainerStyle={styles.container}>
      <Text style={styles.welcome}>Bem-vindo, {user}!</Text>
      {features.map((f) => (
        <TouchableOpacity key={f.id} style={styles.card}>
          <Text style={styles.cardText}>{f.label}</Text>
        </TouchableOpacity>
      ))}
    </ScrollView>
  );
};

const styles = StyleSheet.create({
  container: {
    padding: 16,
    backgroundColor: '#f9f9f9',
  },
  welcome: {
    fontSize: 22,
    fontWeight: 'bold',
    marginBottom: 16,
  },
  card: {
    backgroundColor: '#fff',
    padding: 24,
    borderRadius: 12,
    marginBottom: 12,
    shadowColor: '#000',
    shadowOpacity: 0.1,
    shadowOffset: { width: 0, height: 2 },
    shadowRadius: 4,
    elevation: 2,
  },
  cardText: {
    fontSize: 16,
    fontWeight: '600',
  },
});

export default DashboardScreen;