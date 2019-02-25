package com.stackroute.plasma.service;

import com.stackroute.plasma.model.Description;

import java.util.List;

public interface DescriptionService {

    public Description create(Description description);
    public Description update(Description description);
    public Description delete(Description description);
    /*public List<Node> getAll() {
        return nodeRepository.getAllNodes();
    }

    // @Override
    public Node getOneNode(long id) {
        return nodeRepository.getOneNode(id);
    }

    // @Override
    public Node getOneNode(String name) {
        return nodeRepository.getOneNode(name);
    }

    // @Override
    public Node save(Node node) {
        long id = node.getId();
        String name = node.getName();
        long parentId = node.getParentId();
        return nodeRepository.createNode(id, name, parentId);
    }

    // @Override
    public Node delete(long id) { return nodeRepository.deleteNode(id); }

    // @Override
    public Node delete(String name) {
        return nodeRepository.deleteNode(name);
    }

    // @Override
    public Node update(Node node) {
        long id = node.getId();
        String name = node.getName();
        long parentId = node.getParentId();
        return nodeRepository.updateNode(id, name, parentId);
    }*/
}
