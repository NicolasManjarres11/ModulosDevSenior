import { TestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';

import { BookService, type BookRequestDTO } from './book.service';
import { Book } from '../models/book.model';
import { describe, it, expect, beforeEach } from 'vitest';

describe('BookService', () => {
  let service: BookService;
  let httpMock: HttpTestingController;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [BookService]
    });

    service = TestBed.inject(BookService);
    httpMock = TestBed.inject(HttpTestingController);
  });

  afterEach(() => {
    httpMock.verify();
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it('should call GET to retrieve all books', () => {
    const mockBooks: Book[] = [];

    service.getAllBooks().subscribe((books) => {
      expect(books).toEqual(mockBooks);
    });

    const req = httpMock.expectOne('http://localhost:8080/api/books');
    expect(req.request.method).toBe('GET');
    req.flush(mockBooks);
  });

  it('should call GET to search books', () => {
    const mockBooks: Book[] = [];

    service.searchBooks('angular').subscribe((books) => {
      expect(books).toEqual(mockBooks);
    });

    const req = httpMock.expectOne(
      (request) =>
        request.url === 'http://localhost:8080/api/books/search' &&
        request.params.get('q') === 'angular'
    );

    expect(req.request.method).toBe('GET');
    req.flush(mockBooks);
  });

  it('should call PUT to update a book', () => {
    const dto: BookRequestDTO = {
      title: 'Updated',
      author: 'Author',
      status: 'DESEADO',
      rating: 3,
      ownerId: 1
    };

    const updated: Book = { id: 1, ...dto };

    service.updateBook(1, dto).subscribe((book) => {
      expect(book).toEqual(updated);
    });

    const req = httpMock.expectOne('http://localhost:8080/api/books/1');
    expect(req.request.method).toBe('PUT');
    expect(req.request.body).toEqual(dto);
    req.flush(updated);
  });
});

