package mx.badak.eva.api.service;

import mx.badak.eva.api.model.Candidate;

import java.util.List;
import java.util.Optional;

public interface CandidateService {


    Candidate createCandidate(Candidate candidate);

    List<Candidate> getCandidateAll();
    void deleteCandidate(Integer idCandidato);

    public Candidate updateCandidate(Integer idCandidate, Integer status);

    Optional<Candidate> findById(Integer idCandidate);

    List<Candidate> findByNameLike(String letter);


}
