package mx.badak.eva.api.serviceImpl;

import mx.badak.eva.api.exception.ResourceNotFound;
import mx.badak.eva.api.model.Candidate;
import mx.badak.eva.api.repository.CandidateRepository;
import mx.badak.eva.api.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CandidateServiceImpl implements CandidateService {


    @Autowired
    private CandidateRepository candidateRepository;

    @Override
    public Candidate createCandidate(Candidate candidate) {
        candidate.setStatus(1);

        return candidateRepository.save(candidate);
    }



    @Override
    public List<Candidate> getCandidateAll() {
        return candidateRepository.getCandidateAll();
    }



    @Override
    public void deleteCandidate(Integer idCandidate) {

        candidateRepository.deleteById(idCandidate);
    }



    @Override
    public Candidate updateCandidate(Integer idCandidate, Integer status) {
        return candidateRepository.findById(idCandidate).map(candidate -> {
            candidate.setStatus(status);
            return candidateRepository.save(candidate);
        }).orElseThrow(() -> new ResourceNotFound("id candidate " + idCandidate + " not found"));
    }



    @Override
    public Optional<Candidate> findById(Integer idCandidate) {
        return
                candidateRepository.findById(idCandidate);
    }

    @Override
    public List<Candidate> findByNameLike(String letter) {

        return  candidateRepository.findByNameLike(letter);
    }






}
